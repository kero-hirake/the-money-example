(ns the-money-example.core-test
  (:require [clojure.test :refer :all]
            [the-money-example.money :as money]))

(deftest money-test
  (testing "Dollar を timesで掛け算"
    (testing "5 USD * 2 = 10 USD"
      (let [five (money/dollar 5)]
        (is (= (money/dollar 10) (money/times five 2)))))
    (testing "5 USD * 3 = 15 USD"
      (let [five (money/dollar 5)]
        (is (= (money/dollar 15) (money/times five 3))))))
  (testing "Franc を timesで掛け算"
    (testing "5 CHF * 2 = 10 CHF"
      (let [five (money/franc 5)]
        (is (= (money/franc 10) (money/times five 2)))))
    (testing "5 CHF * 3 = 15 CHF"
      (let [five (money/franc 5)]
        (is (= (money/franc 15) (money/times five 3))))))
  (testing "等価性比較"
    (testing "5 USD = 5 USD"
      (is (money/eq (money/dollar 5) (money/dollar 5))))
    (testing "5 USD != 6 USD"
      (is (not (money/eq (money/dollar 5) (money/dollar 6)))))
    (testing "5 CHF = 5 CHF"
      (is (money/eq (money/franc 5) (money/franc 5))))
    (testing "5 CHF != 6 CHF"
      (is (not (money/eq (money/franc 5) (money/franc 6)))))
    (testing "5 CHF != 5 USD"
      (is (not (money/eq (money/franc 5) (money/dollar 5))))))
  (testing "通貨"
    (testing "1 USD の通貨は :USD"
      (is (= :USD (:currency (money/dollar 1)))))
    (testing "1 CHF の通貨は :CHF"
      (is (= :CHF (:currency (money/franc 1))))))
  )
