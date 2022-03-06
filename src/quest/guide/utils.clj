(ns quest.guide.utils)

(defn slugify
  [string]
  ((comp #(clojure.string/replace % #" " "-")
         clojure.string/lower-case
         clojure.string/trim)
   string))

(defn img [path]
  (str "/imgs/" path))
