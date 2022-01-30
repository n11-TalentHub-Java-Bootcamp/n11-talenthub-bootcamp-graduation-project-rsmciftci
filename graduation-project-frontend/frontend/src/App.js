import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import NavbarComponent from './componenets/NavbarComponent';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import CreditApplicationComponent from './componenets/credit/CreditApplicationComponent';
import FindAppliedCreditComponent from './componenets/credit/FindAppliedCreditComponent';
import SaveCustomerComponent from './componenets/customer/SaveCustomerComponent';
import DeleteCustomerComponent from './componenets/customer/DeleteCustomerComponent';
import UpdateCustomerComponent from './componenets/customer/UpdateCustomerCompenent';










function App() {
  return (
    <div>
      <Router>
        <NavbarComponent/>
        <div>
        <Routes> 
              <Route path = "/save-customer" element={<SaveCustomerComponent></SaveCustomerComponent>}></Route>
              <Route path = "/apply-credit" element={<CreditApplicationComponent></CreditApplicationComponent>}></Route>
              <Route path = "/delete-customer" element={<DeleteCustomerComponent></DeleteCustomerComponent>}></Route>
              <Route path = "/update-customer" element={<UpdateCustomerComponent></UpdateCustomerComponent>}></Route>
              <Route path = "/find-applied-credit" element={<FindAppliedCreditComponent></FindAppliedCreditComponent>}></Route>         
           

        </Routes>
        </div>

      </Router>

     
    </div>
  );
}

export default App;
