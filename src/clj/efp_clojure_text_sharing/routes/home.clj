(ns efp-clojure-text-sharing.routes.home
  (:require [efp-clojure-text-sharing.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]
            [clj-time.core :as t]
            [clj-time.format :as f]
            [efp-clojure-text-sharing.db.core :as db])
  (:import java.security.MessageDigest))

(defn md5 [s]
  (let [algorithm (MessageDigest/getInstance "MD5")
        raw (.digest algorithm (.getBytes s))]
    (format "%032x" (BigInteger. 1 raw))))

(defn home-page []
  (layout/render
    "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page []
  (layout/render "about.html"))

(defn snippet-page [slug]
  (layout/render "slug.html" (db/get-snippet-by-slug slug)))

(defn add-snippet [{:keys [params]}]
  (let [timestamp (f/unparse (f/formatters :date-time) (t/now))
        slug (md5 (str (:snippet params) timestamp))]
    (db/create-snippet {:slug slug :snippet (:snippet params)})
    (response/found (str "/snippets/" slug))))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/snippets" request (add-snippet request))
  (GET "/snippets/:slug" [slug] (snippet-page slug))
  (GET "/about" [] (about-page)))

