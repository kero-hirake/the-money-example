(ns the-money-example.core
  (:gen-class))

(defprotocol IMoney
  (times [this multiplier])
  (plus [this money])
  (eq [this money]))

(defrecord Money [amount currency]
  IMoney
  (times [this multiplier]
    (->Money (* amount multiplier) currency))
  (plus [this money]
    (->Money (+ amount (:amount money)) currency))
  (eq [this money]
    (and
     (= amount (:amount money))
     (= currency (:currency money)))))
