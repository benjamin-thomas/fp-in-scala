(*
   dune exec --display=quiet -w ./chapter01/listing_1.1/cafe.exe

   ---

   Example of a program demonstrating "hard to test" side effects:

   Examples of actions that could happen when charging:
   - contacting the credit card company
   - authorizing the transaction
   - charging the card
   - if successful, persist a record of the transaction for later reference
*)

class coffee =
  object
    val price = 2.0
    method get_price = price
  end

class credit_card =
  object
    method charge (price : float) : unit =
      print_endline ("Charging: " ^ string_of_float price)
  end

class cafe =
  object
    method buy_coffee (cc : credit_card) : coffee =
      let cup = new coffee in
      cc#charge cup#get_price;
      cup
  end

let () =
  let cafe = new cafe in
  let cc = new credit_card in
  let cup = cafe#buy_coffee cc in
  Printf.printf "Enjoy your coffee! (price was: %.2f)\n" cup#get_price
;;
