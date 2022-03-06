(ns quest.guide.freeze
  (:require [clojure.java.io :as io]
            [lambdaisland.ornament :as ornament]
            [lambdaisland.reitit-jaatya.freeze :as freeze]
            [quest.guide.http :as http]))

(defn build [& args]
  (let [css-file "resources/public/ui/main.css"]
    (io/make-parents css-file)
    (spit css-file (ornament/defined-styles {:preflight? true})))
  (freeze/iced (http/build-handler) {:sitemap-path "/sitemap.xml"
                                     :sitemap-trailing-slash true
                                     :base-url "https://clojure.quest"}))
