(ns the-money-example.franc)

(defprotocol Calc
  (times [this mulitplier])
  (eq [this object]))

(defrecord Franc [amount]
  Calc
  (times [this mulitplier]
    (->Franc (* amount mulitplier)))
  (eq [this object]
    (= amount (:amount object))))
