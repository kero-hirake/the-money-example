(ns the-money-example.franc
  (:require [the-money-example.money :as money]))

(defprotocol Calc
  (times [this mulitplier]))

(defrecord Franc [amount]
  Calc
  (times [this mulitplier]
    (->Franc (* amount mulitplier)))
  money/IMoney
  (money/eq [this object]
    (= amount (:amount object))))
