(ns the-money-example.dollar)

(defprotocol Calc
  (times [this mulitplier])
  (eq [this object]))

(defrecord Dollar [amount]
  Calc
  (times [this mulitplier]
    (->Dollar (* amount mulitplier)))
  (eq [this object]
    (= amount (:amount object))))
