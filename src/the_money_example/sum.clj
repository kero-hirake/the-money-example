(ns the-money-example.sum
  (:require [the-money-example.expression :as expression]))

(defrecord Sum [augend addend]
  expression/IExpression)