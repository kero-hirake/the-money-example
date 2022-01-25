(ns the-money-example.money
  (:require [the-money-example.sum :as sum]
            [the-money-example.expression :as expression]))

(defprotocol IMoney
  (eq [this other])
  (times [this mulitplier])
  (plus [this other]))

(defrecord Money [amount currency]
  IMoney
  (eq [this other]
    (and
     (= (:amount this) (:amount other))
     (= (:currency this) (:currency other))))
  
  (times [this mulitplier]
    (->Money (* amount mulitplier) currency))
  
  (plus [this addend]
    (sum/->Sum this addend))
  
  expression/IExpression)

(defn dollar [amount]
  (->Money amount :USD))

(defn franc [amount]
  (->Money amount :CHF))
