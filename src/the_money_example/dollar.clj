(ns the-money-example.dollar
  (:require [the-money-example.money :as money]))

(defprotocol Calc
  (times [this mulitplier]))

(defrecord Dollar [amount]
  Calc
  (times [this mulitplier]
    (->Dollar (* amount mulitplier)))
  money/IMoney
  (money/eq [this object]
    (= amount (:amount object))))

