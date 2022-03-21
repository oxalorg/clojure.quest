(ns quest.guide.layout
  (:require [clojure.java.io :as io]
            [clojure.data.json :as json]
            [quest.guide.utils :as utils]
            [lambdaisland.ornament :as o :refer [defstyled]]))

(o/set-tokens! {:fonts {:primary "Atkinson Hyperlegible,-apple-system,BlinkMacSystemFont,Segoe UI,Helvetica,Arial,sans-serif,Apple Color Emoji,Segoe UI Emoji"
                        :fancy "bitoperator-regular"
                        :fancy-bold "bitoperator-bold"}})

(defn get-script-name
  "Read the manifest.edn file, and get the current main.HASHCODE.js filename
   (get-script-name :main) => main.HASHCODE.js "
  [module-id-k]
  (some->> (io/resource "public/ui/manifest.edn")
           slurp
           read-string
           (filter #(= module-id-k (:module-id %)))
           first
           :output-name))

(defstyled ground :div
  :h-8
  :w-full
  :bg-gradient-to-b
  :from-rgb-560d37
  :to-black
  ([]
   [:div]))

(defstyled sky :div
  :h-8
  :w-full
  :bg-gradient-to-t
  :from-rgb-020034
  :to-black
  ([]
   [:div]))

(defstyled footer :footer
  :pt-8
  :text-center :font-fancy :text-white :bg-black
  [:>.love
   [:>img :w-4 :h-4 :inline]
   [:>a :text-rose-400]]
  ([]
   [:<>
    [:p.love "Made with "
     [:img {:src (utils/img "icons/heart.png")}]
     " by "
     [:a {:href "https://twitter.com/oxalorg"} "@oxalorg"]]
    [sky]
    [ground]]))

(defstyled app :div
  :font-primary
  ([body]
   body))

(defstyled page :div
  [:>main :md:container :mx-auto]
  ([children]
   [:<>
    [:main
     children]
    [footer]]))

(defstyled page-fluid :div
  ([children]
   [:<>
    children
    [footer]]))

(defn layout
  ([body]
   [layout nil body])
  ([head body]
   [:html
    [:head
     [:meta {:charset "UTF-8"}]
     [:meta {:content "width=device-width, initial-scale=1" :name "viewport"}]
     [:link {:rel "icon" :href "/favicon.ico" :type "image/png"}]
     [:link {:rel "apple-touch-icon" :sizes "48x48" :href "/icons/icon-48x48.png"}]
     [:link {:rel "apple-touch-icon" :sizes "72x72" :href "/icons/icon-72x72.png"}]
     [:link {:rel "apple-touch-icon" :sizes "96x96" :href "/icons/icon-96x96.png"}]
     [:link {:rel "apple-touch-icon" :sizes "128x128" :href "/icons/icon-128x128.png"}]
     [:link {:rel "apple-touch-icon" :sizes "48x48" :href "/icons/icon-48x48.png"}]
     [:link {:rel "apple-touch-icon" :sizes "144x144" :href "/icons/icon-144x144.png"}]
     [:link {:rel "apple-touch-icon" :sizes "192x192" :href "/icons/icon-192x192.png"}]
     [:link {:rel "apple-touch-icon" :sizes "256x256" :href "/icons/icon-256x256.png"}]
     [:link {:rel "apple-touch-icon" :sizes "384x384" :href "/icons/icon-384x384.png"}]
     [:link {:rel "apple-touch-icon" :sizes "512x512" :href "/icons/icon-512x512.png"}]

     [:link {:rel "preconnect" :href "https://fonts.googleapis.com"}]
     [:link {:rel "preconnect" :href "https://fonts.gstatic.com"}]
     [:link {:href "https://fonts.googleapis.com/css2?family=Atkinson+Hyperlegible:wght@400;700&display=swap" :rel "stylesheet"}]
     [:link {:href "/css/global.css" :rel "stylesheet"}]

     (if (io/resource "public/ui/main.css")
       [:link {:rel "stylesheet" :href (str "/ui/main.css?v=" (System/currentTimeMillis))}]
       [:style {:type "text/css" :id "ornament"}
        (o/defined-styles {:preflight? true})])
     head]
    [:body {:class "font-primary"}
     [app body]
     [:script {:type "application/javascript"
               :src (str "/ui/" (get-script-name :main))}]]]))
