(ns the-money-example.core-test
  (:require [clojure.test :refer :all]
            [the-money-example.money :as money]
            [the-money-example.dollar :as usd]
            [the-money-example.franc :as chf]))

(deftest money-test
  (testing "Dollar を timesで掛け算"
    (testing "5 USD * 2 = 10 USD"
      (let [five (usd/->Dollar 5)]
        (is (= (usd/->Dollar 10) (usd/times five 2)))))
    (testing "5 USD * 3 = 15 USD"
      (let [five (usd/->Dollar 5)]
        (is (= (usd/->Dollar 15) (usd/times five 3))))))
  (testing "Franc を timesで掛け算"
    (testing "5 CHF * 2 = 10 CHF"
      (let [five (chf/->Franc 5)]
        (is (= (chf/->Franc 10) (chf/times five 2)))))
    (testing "5 CHF * 3 = 15 CHF"
      (let [five (chf/->Franc 5)]
        (is (= (chf/->Franc 15) (chf/times five 3))))))
  (testing "等価性比較"
    (testing "5 USD = 5 USD"
      (is (money/eq (usd/->Dollar 5) (usd/->Dollar 5))))
    (testing "5 USD != 6 USD"
      (is (not (money/eq (usd/->Dollar 5) (usd/->Dollar 6)))))
    (testing "5 CHF = 5 CHF"
      (is (money/eq (chf/->Franc 5) (chf/->Franc 5))))
    (testing "5 CHF != 6 CHF"
      (is (not (money/eq (chf/->Franc 5) (chf/->Franc 6)))))
    (testing "5 CHF != 5 USD"
      (is (not (money/eq (chf/->Franc 5) (usd/->Dollar 5)))))))
