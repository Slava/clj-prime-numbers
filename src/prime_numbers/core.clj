(ns prime-numbers.core
  (:gen-class))

(defn divisible?
  "Tests for divisibility"
  [number divider]
  (= 0 (mod number divider)))

(defn first-primes
  "Returns first N prime numbers"
  [N]
  (loop [all-primes []
         remaining-primes N
         candidate 2]
    (if (= 0 remaining-primes)
      all-primes
      (if (not-any? #(divisible? candidate %) all-primes)
        (recur (conj all-primes candidate) (dec remaining-primes) (inc candidate))
        (recur all-primes remaining-primes (inc candidate))))))

(defn -main
  "Prints first X prime numbers"
  [primes-number & args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println (first-primes (Integer. primes-number))))
