import React, { Component } from 'react';
import {Card, Form, Button, Row,Col} from 'react-bootstrap';
import axios from 'axios'; 



class DeleteCustomerComponent extends Component {

  constructor (props){
    super(props);
    this.state = this.initialState;
    this.customerChange = this.customerChange.bind(this);
    this.submitCustomer = this.submitCustomer.bind(this);
  }
  initialState = {
    turkishIdentityNumber:'',
      dateOfBirth:''
  }

  resetCustomer = () =>{

    this.setState(() => this.initialState);
  }

  submitCustomer = event =>{
      event.preventDefault();

      const customer = {
      turkishIdentityNumber : this.state.turkishIdentityNumber,   
      dateOfBirth   :  this.state.dateOfBirth
 

      };

      axios.delete("http://localhost:8080/api/customers/delete-by-"+customer.turkishIdentityNumber+"&"+customer.dateOfBirth,customer).then(response =>{
          if(response.status === 200){
            this.setState(this.initialState);
            alert("Customer Deleted Successfully");
          }
      }).catch(
          error => {
            alert("Something Went Wrong!\nALL VALUES IN THE CORRECT FORM!");        
          }

      );
   
  }

  customerChange(event){
      this.setState({
          [event.target.name]:event.target.value
      })

  }

    render() {
      const {turkishIdentityNumber, dateOfBirth     } = this.state;


        return (
          <Card className={"border border-dark bg-light text-white"}>
                  <Card.Header className='text-black'>DELETE A CUSTOMER</Card.Header>
                  <Form onReset={this.resetCustomer} onSubmit={this.submitCustomer} id="customerFormId">
                  <Card.Body>
                   
                      <Row>
                         <Form.Group as={Col} controlId="formGridTurkishIdentityNumber">
                              <Form.Label className='text-black'>Turkish Identity Number</Form.Label>
                              <Form.Control required autoComplete='off'
                                  name = "turkishIdentityNumber"
                                  type="text"
                                  value={turkishIdentityNumber}
                                  onChange={this.customerChange} 
                                  placeholder="Enter Turkish Identity Number" />                         
                        </Form.Group>
                     
                        <Form.Group as={Col}  controlId="formGridDateOfBirth">
                              <Form.Label className='text-black'>Date Of Birth ( YYYY-MM-DD )</Form.Label>
                              <Form.Control required autoComplete='off'
                                  name="dateOfBirth"
                                  type="text"
                                  value={dateOfBirth}
                                  onChange={this.customerChange} 
                                  placeholder="YYYY-MM-DD" />                         
                        </Form.Group> 
                     
                      </Row>   
                   
                                      


                  </Card.Body>  

                  <Card.Footer style={{"textAlign":"right"}}>

                        <Button size ="sm" class="btn btn-primary btn-lg button-space" variant="success" type="submit">
                            Submit
                        </Button>   
                                               
                        <Button  size ="sm"  variant="info" type="reset">
                           Reset
                        </Button>

                  </Card.Footer>
                  </Form>

          </Card>
        
        );
    }
}

export default DeleteCustomerComponent;