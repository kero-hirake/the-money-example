(ns the-money-example.bank
  (:require [the-money-example.money :as money]))

(defprotocol IBank
  (redu [this source to]))

(defrecord Bank []
  IBank
  (redu [this source to]
        (money/dollar 10)))

