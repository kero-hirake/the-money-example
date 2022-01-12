(ns the-money-example.core
  (:gen-class))

(defprotocol Calc
  (times [this n]))

(defrecord Dollar [amount]
  Calc
  (times [this n]))
