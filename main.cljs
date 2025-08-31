(ns main
  (:require
    [reagent.core :as r]
    [reagent.dom :as rdom]))

(defonce !counter (r/atom 0))

(defn increment! []
  (swap! !counter inc)
  ; (js/setTimeout increment! 100)
  (js/window.requestAnimationFrame increment!))

(defn app []
  [:main
   [:h1 "Outer counter"]
   [:pre "Count: " (pr-str @!counter)]
   [:iframe {:src "https://adamrenklint.com/outer-sandbox-test"
             :sandbox "allow-scripts"
             :style {:height 400 :width 500
                     :border "1px solid lightgrey"}}]])

(rdom/render [app] (.getElementById js/document "app"))

(increment!)
