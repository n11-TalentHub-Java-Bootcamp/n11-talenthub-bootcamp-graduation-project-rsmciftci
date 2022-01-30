import React, { Component } from 'react';
import {Card, Form, Button, Row,Col, Table} from 'react-bootstrap';
import axios from 'axios'; 





class FindAppliedCreditComponent extends Component {

  constructor (props){
    super(props); 
    this.state = this.initialState;
 
    this.state = {   
      creditResultEnum :'',
      creditLimit : ''

    }  
    this.customerChange = this.customerChange.bind(this);
    this.submitCustomer = this.submitCustomer.bind(this);  
    
  }

  
  initialState = {
   turkishIdentityNumber:'',     
   dateOfBirth:'',  
   creditResultEnum:'',
   creditLimit:''  
  
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

     /* axios.get("http://localhost:8080/api/credit-application/by-"+customer.turkishIdentityNumber+"&"+customer.dateOfBirth,customer)
      .then(response =>{
        if(response.status === 200){
            this.setState(this.initialStateOfInput);
            this.creditResultEnum = response.data.creditResultEnum;   
            alert("Credit Application Found.");
          }
      }).catch(
          error => {
            alert("Something Went Wrong!\n\nMake Sure,Customer Already Saved,\nCustomer Salary Updated,\nHas No Credit Application,\nALL VALUES IN THE CORRECT FORM!");        
          }

      );*/

      axios.get("http://localhost:8080/api/credit-application/by-"+customer.turkishIdentityNumber+"&"+customer.dateOfBirth,customer)
          .then(response => response.data)
          .then((data) => {this.setState({creditResultEnum: data.creditResultEnum, creditLimit : data.creditLimit})})
          .catch(
            error => {
              alert("Something Went Wrong!\n\nMake Sure,Customer Already Saved,\nCustomer Salary Updated,\nHas No Credit Application,\nALL VALUES IN THE CORRECT FORM!");        
            }
  
        );
  
   
  }

  customerChange(event){
      this.setState({
          [event.target.name]:event.target.value
      })

  }



    render() {
      const {turkishIdentityNumber,  dateOfBirth  } = this.state;


        return (

          
          <Card className={"border border-dark bg-light text-white"}>
                  <Card.Header className='text-black'>FIND APPLIED CREDIT</Card.Header>
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
                

        
<Card.Header className='text-black'>Credit Application Result</Card.Header>
<Card.Body>
    <Table>
    <thead>
    <tr>      
      <th>Credit Result</th>
      <th>Credit Limit</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      
     
        <td>{this.state.creditResultEnum}</td>

      
     
      <td>{this.state.creditLimit}</td>    
    </tr>   
  </tbody>
    </Table>
</Card.Body>

</Card>






     
        
        );
    }
}

export default FindAppliedCreditComponent;