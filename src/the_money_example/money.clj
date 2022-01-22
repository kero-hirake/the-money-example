(ns the-money-example.money
  (:require [the-money-example.dollar :as usd]
            [the-money-example.franc :as chf]))

(defprotocol IMoney
  (eq [this other])
  (times [this mulitplier]))

(defrecord Money [amount currency]
  IMoney
  (eq [this other]
    (and
     (= (:amount this) (:amount other))
     (= (:currency this) (:currency other))))
  (times [this mulitplier]
    (->Money (* amount mulitplier) currency)))

(defn dollar [amount]
  (->Money amount :USD))

(defn franc [amount]
  (->Money amount :CHF))