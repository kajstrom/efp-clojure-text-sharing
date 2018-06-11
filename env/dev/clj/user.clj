(ns user
  (:require [efp-clojure-text-sharing.config :refer [env]]
            [clojure.spec.alpha :as s]
            [expound.alpha :as expound]
            [mount.core :as mount]
            [efp-clojure-text-sharing.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'efp-clojure-text-sharing.core/repl-server))

(defn stop []
  (mount/stop-except #'efp-clojure-text-sharing.core/repl-server))

(defn restart []
  (stop)
  (start))


