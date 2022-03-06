(ns quest.guide.routes
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.java.shell :as sh]
            [clojure.string :as str]
            [quest.guide.db :as db]
            [quest.guide.home :as home]
            [quest.guide.layout :as layout]
            [quest.guide.open-graph :as og]))

(defn get-version [_]
  (let [commit (-> (sh/sh "git" "rev-parse" "HEAD") :out str/trim)]
    {:status 200
     :body {:commit commit}
     :view #(:commit %)}))

(defn get-home [_]
  {:status 200
   ;; Make the body plain EDN, this is what you will get if
   ;; you request JSON/EDN/etc.
   :body {}
   ;; View is a function from EDN to Hiccup (receives the body data)
   :view (fn [data]
           [layout/layout
            (og/social-tags {:image ""})
            [:div#home-app
             [home/page data]]])})

(defn routes []
  [["/"
    {:name ::home
     :get {:handler get-home}}]
   ["/data.json"
    {:name ::home-json
     :freeze-content-type :json
     :get {:handler get-home}}]
   ["/version"
    {:name ::version
     :get {:handler get-version}}]])
