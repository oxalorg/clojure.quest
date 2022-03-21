(ns quest.guide.db
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.string :as str]
            [markdown.core :as m]
            [quest.guide.utils :as utils])
  (:import (java.io StringWriter)))

(defn- read-edn [file-name]
  (-> file-name
      io/resource
      slurp
      edn/read-string))

(defn- get-content-files
  "Generic for now, needs subdivisions later on"
  []
  (filter
   #(str/ends-with? (.getName %) ".md")
   (file-seq (io/file "content/journal"))))

(defn- meta-markdown [input]
  (let [output (new StringWriter)
        metadata (m/md-to-html input output :parse-meta? true)
        html     (.toString output)
        meta (if (nil? (:slug metadata))
               (assoc metadata :slug (utils/slugify (:title metadata)))
               metadata)]
    {:meta meta :html html}))

(defn- get-journal-entries []
  (into {}
        (comp
         (map meta-markdown)
         (map (juxt #(get-in % [:meta :slug]) identity)))
        (get-content-files)))

(def journal-entries (delay (get-journal-entries)))

(def story
  (delay
    (->> "story.edn"
         (read-edn))))
