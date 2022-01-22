(ns the-money-example.dollar)

(defprotocol Calc
  (times [this mulitplier]))

(defrecord Dollar [amount currency]
  Calc
  (times [this mulitplier]
    (->Dollar (* amount mulitplier) currency)))

