(ns quest.guide.open-graph
  (:require [clojure.data.json :as json]))

;; defaults
(def twitter-site "@oxalorg")
(def twitter-creator "@oxalorg")
(def title "Clojure Quest")
(def description "Start your quest to learn Clojure and level up your skills.")
(def url "https://clojure.quest")

(defn twitter-card-tags [{:keys [tw-type tw-site tw-creator url
                                 title description image]
                          :or {tw-type "summary"
                               tw-site twitter-site
                               tw-creator twitter-creator
                               title title
                               description description
                               url url
                               #_#_image logo-image}}]
  {"twitter:card" tw-type
   "twitter:site" tw-site
   "twitter:creator" tw-creator
   "twitter:url" url
   "twitter:title" title
   "twitter:description" description
   "twitter:image" image})

(defn open-graph-tags [{:keys [url og-type title updated-time modified-time
                               published-time site-name description section
                               image video-duration video-release-date]
                        :or {og-type "article"
                             site-name title
                             description description
                             title title
                             #_#_image logo-image}}]
  {"og:url" url
   "og:type" og-type
   "og:title" title
   "og:updated_time" updated-time
   "og:site-name" site-name
   "og:description" description
   "og:image" image
   "article:modified_time" modified-time
   "article:published_time" published-time
   "article:section" section
   "video:release_date" video-release-date
   "video:duration" video-duration})

(defn video-structured-schema [{:keys [id name description upload-date thumbnail-url] :as video}]
  (let [schema (merge {"@context" "https://schema.org"
                       "@type" "VideoObject"
                       "name" name
                       "description" description
                       "uploadDate" upload-date
                       "thumbnailUrl" thumbnail-url
                       "embed-url" ""})]
    [:script {:type "application/ld+json"}
     (json/write-str schema :escape-slash false)]))

(defn generic-meta-tags [tags]
  {"description" (:description tags description)})

(defn social-tags [tags]
  (into [:<>
         [:title (:title tags title)]
         (when (:video-schema tags)
           (video-structured-schema (:video-schema tags)))]
        (comp
         cat
         (remove (comp nil? second))
         (map #(do [:meta {:name (first %) :content (second %)}])))
        [(generic-meta-tags tags)
         (twitter-card-tags tags)
         (open-graph-tags tags)]))
