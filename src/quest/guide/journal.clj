(ns quest.guide.journal
  (:require [quest.guide.components.blog :as blog]
            [quest.guide.db :as db]
            [quest.guide.layout :as layout]
            [quest.guide.open-graph :as og]))

(defn get-index [_]
  {:status 200
   :body {:posts (vals @db/journal-entries)}
   :view (fn [{:keys [posts]}]
           [layout/layout
            (og/social-tags {:image ""})
            [layout/page
             (blog/index posts)]])})

(defn get-entry [request]
  (let [{:keys [slug]} (:path-params request)
        post (get @db/journal-entries slug)]
    {:status 200
     :body {:slug slug
            :post post}
     :view (fn [{:keys [slug post] :as data}]
             (let [{:keys [meta html]} post]
               [layout/layout
                (og/social-tags {:title (:title meta)
                                 :description ""})
                [layout/page
                 [blog/entry post]]]))}))
