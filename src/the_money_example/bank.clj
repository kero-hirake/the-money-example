(ns the-money-example.bank
  (:require [the-money-example.expression :as expr]))

(defprotocol IBank
  (redu [this source to]))

(defrecord Bank []
  IBank
  (redu [this source to]
        (expr/redu source to)))

