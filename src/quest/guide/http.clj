(ns quest.guide.http
  (:require [lambdaisland.webstuff.http :as http]
            [lambdaisland.glogc :as log]
            [quest.guide.routes :as routes]
            [reitit.ring :as ring]
            [clojure.java.io :as io]
            [lambdaisland.webstuff.bootstrap :as bootstrap]
            [integrant.core :as ig]))

(bootstrap/set-config! (io/resource "config.edn"))

(defn default-handler []
  (ring/routes
   (ring/create-resource-handler {:path "/"})
   (ring/redirect-trailing-slash-handler {:method :strip})
   (ring/create-default-handler nil)))

(defn build-handler []
  (http/ring-handler {:routes (routes/routes)
                      :default-handler (default-handler)}))

(defmethod ig/init-key ::server [_ {:keys [port rebuild-on-request?] :as config}]
  (http/start-jetty! (assoc config :build-handler #'build-handler)))

(defmethod ig/halt-key! ::server [_ jetty]
  (http/stop-jetty! jetty))

(defn -main [& [profile]]
  (let [profile (or profile "dev")]
    (bootstrap/go (keyword profile)))
  @(promise))
