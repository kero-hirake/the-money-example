(ns the-money-example.dollar)

(defprotocol Calc
  (times [this mulitplier]))

(defrecord Dollar [amount]
  Calc
  (times [this mulitplier]
         (* amount mulitplier)))
