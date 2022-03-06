(ns quest.guide.home
  (:require [lambdaisland.ornament :as o :refer [defstyled]]
            [quest.guide.utils :as utils]))

(defstyled banner :div
  :w-full :h-full
  ([]
   [:image {:src (utils/img "banner.jpg")}]))

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

(defstyled newsletter :div
  :mx-auto :mt-8
  :font-fancy-bold
  :max-w-xl :p-8
  :border-2 :border-teal-400 :rounded-lg
  [:>form
   [:p :text-2xl]
   [:label :text-lg :mt-4 :block :text-teal-400]
   [:input :mr-4 :mt-4 :p-2 :w-64 :text-fuchsia-600 :rounded-lg]
   [:button :border-2 :border-teal-400 :p-2 :rounded-lg]]
  ([]
   [:form {:action "https://tinyletter.com/oxalorg" :method "post"}
    [:p "Quest updates"]
    [:label {:for "newsletter"} "3 line emails only. No more. Read within 9.17 seconds or my character dies!"]
    [:div {:class "relative flex items-center max-w-xs"}
     [:input#newsletter
      {:placeholder "Your email"
       :name "email"
       :type "email"}]
     [:button
      {:aria-label "Subscribe" :type "submit"}
      "Subscribe"]]]))

(defstyled header :header
  :text-center :font-fancy :text-white :bg-black
  :p-4
  [:>h2 :text-6xl :mt-8 :font-fancy-bold]
  [:>.desc :mt-8 :max-w-lg :mx-auto :leading-relaxed :text-gray-400
   [:>span :mt-4 :block]]
  [:>.start :text-gray-400 :text-2xl :mt-8 :font-fancy-bold]
  [:>.repo
   :mt-2
   :text-gray-400
   [:>a :text-amber-500]]
  [:>.love
   :mt-8
   [:>img :w-4 :h-4 :inline]
   [:>a :text-rose-400]]
  ([]
   [:<>
    [:h2 "Clojure Quest"]
    [:p.desc
     [:span "Welcome fellow traveller! You don't seem to be from around here, do ya?"]
     [:span "Oh I see, you have travelled far and wide from across the Nothern plains in search for the one true paren, the paren to rule them all?"]
     [:span "Take my heed o youngling, the paths beyond here are thorny and difficult. But there's a secret..."]
     [:span "Take this REPL. This is a wand of immense power; learn to use it, use it wisely. The power of the REPL corrupts absolutely, don't let it consume you lest you want to return back to the worlds of humankind."]
     [:span "Start your quest here to follow the paths of Clojure and find the one true paren!"]]

    [:div.start
     [:a {:href "#"} "Our wizards are reifying the quests! Stay tuned"]]

    [:p.repo "REPL potions being brewed at "
     [:a {:href "https://github.com/oxalorg/clojure.quest"} "github.com/oxalorg/clojure.quest"]]

    [newsletter]

    [:p.love "Made with "
     [:img {:src (utils/img "icons/heart.png")}]
     " by "
     [:a {:href "https://twitter.com/oxalorg"} "@oxalorg"]]

    ]))

(defn page [{:keys []}]
  [:div
   [header]
   [sky]
   #_[banner]
   [ground]])
