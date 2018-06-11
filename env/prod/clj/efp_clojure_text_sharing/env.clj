(ns efp-clojure-text-sharing.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[efp-clojure-text-sharing started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[efp-clojure-text-sharing has shut down successfully]=-"))
   :middleware identity})
