(ns armstrong-numbers)

;; Armstrong number explanation:
;; 9 is an Armstrong number, because 9 = 9^1 = 9
;; 10 is not an Armstrong number, because 10 != 1^2 + 0^2 = 1
;; 153 is an Armstrong number, because: 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153

; FEEDBACK
; Even though your (defn calc-armstrong...) is inlined, defn, 
; Clojure compiles def and defn constructs as global vars. 
; You ought to use let (in place of def) and letfn (in place of defn) to achieve lexical scope.

(defn pow [b e]
  (.pow (BigInteger. (str b)) e))

(defn digits [num]
  (map #(Character/digit % 10) (str num)))

(defn armstrong? [num]
  (letfn [
    (calc-armstrong [num]
      (->> (map #(pow % (count (str num))) (digits num))
           (reduce +)))]

    (= (long num) (long (calc-armstrong num)))))