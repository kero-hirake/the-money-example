(ns the-money-example.core
  (:gen-class))

(defprotocol IMoney
  (times [this multiplier])
  (eq [this money]))

(defrecord Money [amount currency]
  IMoney
  (times [this multiplier]
    (->Money (* amount multiplier) currency))
  (eq [this money]
    (and
     (= amount (:amount money))
     (= currency (:currency money)))))
