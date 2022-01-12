(ns the-money-example.core
  (:gen-class))

(defprotocol Calc
  (times [this multiplier]))

(defrecord Dollar [amount]
  Calc
  (times [this multiplier]
    (->Dollar (* amount multiplier))))

