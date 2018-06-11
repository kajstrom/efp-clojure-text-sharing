(ns efp-clojure-text-sharing.handler
  (:require 
            [efp-clojure-text-sharing.layout :refer [error-page]]
            [efp-clojure-text-sharing.routes.home :refer [home-routes]]
            [compojure.core :refer [routes wrap-routes]]
            [compojure.route :as route]
            [efp-clojure-text-sharing.env :refer [defaults]]
            [mount.core :as mount]
            [efp-clojure-text-sharing.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
      (-> #'home-routes
          (wrap-routes middleware/wrap-csrf)
          (wrap-routes middleware/wrap-formats))
          (route/not-found
             (:body
               (error-page {:status 404
                            :title "page not found"}))))))

