(ns the-money-example.franc)
 
(defprotocol Calc
  (times [this mulitplier]))

(defrecord Franc [amount]
  Calc
  (times [this mulitplier]
    (->Franc (* amount mulitplier))))
