(ns the-money-example.franc)
 
(defprotocol Calc
  (times [this mulitplier]))

(defrecord Franc [amount currency]
  Calc
  (times [this mulitplier]
    (->Franc (* amount mulitplier) currency)))
