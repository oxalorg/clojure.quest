(ns quest.guide.components.blog
  (:require [lambdaisland.ornament :as o :refer [defstyled]]))

(defstyled list :section
  :m-4 :mt-12
  [:>h2 :font-fancy-bold :text-4xl]
  [:>ul :list-disc
   [:>li :flex :my-4 :text-lg :justify-between
    [:>date :text-base]]]
  ([posts]
   (println posts)
   [:<>
    [:h2 "Journal entries"]
    [:ul
     (for [{:keys [meta html]}posts]
       [:li
        [:a
         {:href (str "/journal/" (:slug meta))}
         (:title meta)]
        [:date
         (.format (java.text.SimpleDateFormat. "dd MMM, YY") (:date meta))]
        ])]]))

(defstyled entry :div
  ([{:keys [meta html] :as post}]
   [:<>
    [:h1 (:title meta)]
    [:div.post-meta
     "Posted on "
     [:span (.format (java.text.SimpleDateFormat. "MMM dd, yyyy") (:date meta))]
     " by "
     [:span (:author meta)]]
    [:lambdaisland.hiccup/unsafe-html html]])
  )
