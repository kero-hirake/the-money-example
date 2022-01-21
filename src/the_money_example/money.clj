(ns the-money-example.money)

(defprotocol IMoney
  (eq [this object]))
