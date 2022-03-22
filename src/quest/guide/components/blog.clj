(ns quest.guide.components.blog
  (:require [lambdaisland.ornament :as o :refer [defstyled]]))

(defstyled prose :div
  :text-lg :leading-normal
  [:p :mt-5]
  [:h1 :border-b-1 :border-gray-200 :pb-2 :mt-4 :font-fancy-bold :text-5xl]
  [:h2 :border-b-1 :border-gray-200 :pb-2 :mt-4 :font-fancy-bold :text-3xl]
  [:h3 :border-b-1 :border-gray-200 :pb-2 :mt-4 :font-fancy-bold :text-xl]
  [:h4 :border-b-1 :border-gray-200 :pb-2 :mt-4 :font-fancy-bold :text-lg]
  [:h5 :border-b-1 :border-gray-200 :pb-2 :mt-4 :font-fancy-bold :text-base]
  [:h6 :border-b-1 :border-gray-200 :pb-2 :mt-4 :font-fancy-bold :text-sm]
  [:ul :list-disc :list-inside :mt-4]
  [:li :mt-2]
  [:a :text-teal-600]
  [:blockquote
   :mt-4 :pl-4 :border-l-5 :border-teal-600 :py-4 :pr-3 :bg-teal-50
   [:>p:first-child :mt-0]]
  )

(defstyled index :section
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
  :m-4 :mt-12
  [:>h1 :font-fancy-bold :text-4xl]
  [:.post-meta :mt-4]
  [:>main :my-4]
  ([{:keys [meta html] :as post}]
   [:<>
    [:h1 (:title meta)]
    [:div.post-meta
     "Posted on "
     [:span (.format (java.text.SimpleDateFormat. "MMM dd, yyyy") (:date meta))]
     " by "
     [:span (:author meta)]]
    [prose
     [:lambdaisland.hiccup/unsafe-html html]]])
  )
