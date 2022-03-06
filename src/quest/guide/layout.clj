(ns quest.guide.layout
  (:require [clojure.java.io :as io]
            [clojure.data.json :as json]
            [lambdaisland.ornament :as o]))

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

(o/defstyled app :div
  :font-primary
  ([body]
   body))

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
       [:link {:rel "stylesheet" :href "/ui/main.css"}]
       [:style {:type "text/css" :id "ornament"}
        (o/defined-styles {:preflight? true})])
     head]
    [:body {:class "font-primary"}
     [app body]
     [:script {:type "application/javascript"
               :src (str "/ui/" (get-script-name :main))}]]]))
