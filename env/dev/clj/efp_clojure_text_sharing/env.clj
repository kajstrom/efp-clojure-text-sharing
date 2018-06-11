(ns efp-clojure-text-sharing.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [efp-clojure-text-sharing.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[efp-clojure-text-sharing started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[efp-clojure-text-sharing has shut down successfully]=-"))
   :middleware wrap-dev})
