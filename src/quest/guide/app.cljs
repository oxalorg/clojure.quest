(ns quest.guide.app
  (:require [lambdaisland.glogi :as log]
            [lambdaisland.glogi.console :as glogi-console]))

(defn ^:dev/after-load start []
  ;; mount here
  )

(defn init []
  (glogi-console/install!)
  (log/set-levels {:glogi/root :all})
  (start))
