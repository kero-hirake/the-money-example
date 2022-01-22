(ns the-money-example.money
  (:require [the-money-example.dollar :as usd]
            [the-money-example.franc :as chf])
  )

#_(defprotocol IMoney
  (eq [this object]))

(defn eq [this object]
  (and
   (= (:amount this) (:amount object))
   (= (class this) (class object))))

(defn dollar [amount]
  (usd/->Dollar amount))

(defn franc [amount]
  (chf/->Franc amount))