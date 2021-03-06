(ns efp-clojure-text-sharing.db.core
    (:require [monger.core :as mg]
              [monger.collection :as mc]
              [monger.operators :refer :all]
              [mount.core :refer [defstate]]
              [efp-clojure-text-sharing.config :refer [env]]))

(defstate db*
  :start (-> env :database-url mg/connect-via-uri)
  :stop (-> db* :conn mg/disconnect))

(defstate db
  :start (:db db*))

(def coll "snippets")

(defn create-snippet [snippet]
  (mc/insert db coll snippet))

(defn get-snippet-by-slug [slug]
  (mc/find-one-as-map db coll {:slug slug}))

;(defn create-user [user]
;  (mc/insert db "users" user))

;(defn update-user [id first-name last-name email]
;  (mc/update db "users" {:_id id}
;             {$set {:first_name first-name
;                    :last_name last-name
;                    :email email}}))

;(defn get-user [id]
;  (mc/find-one-as-map db "users" {:_id id}))
