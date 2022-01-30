import React, { Component } from 'react';
import {Nav,NavDropdown,Container,Navbar} from 'react-bootstrap';

class NavbarComponent extends Component {
    render() {
        return (
            <div>
                <Navbar bg="light" expand="lg">
  <Container>
    <Navbar.Brand href="">n11</Navbar.Brand>
    <Navbar.Toggle aria-controls="basic-navbar-nav" />
    <Navbar.Collapse id="basic-navbar-nav">
      <Nav className="me-auto">
        <Nav.Link href="home">Home</Nav.Link>       
        <NavDropdown title="Customer" id="basic-nav-dropdown">
          <NavDropdown.Item href="save-customer">Save</NavDropdown.Item>
          <NavDropdown.Item href="update-customer">Update</NavDropdown.Item>
          <NavDropdown.Item href="delete-customer">Delete</NavDropdown.Item>          
        </NavDropdown>
        <NavDropdown title="Credit" id="basic-nav-dropdown">
          <NavDropdown.Item href="apply-credit">Apply</NavDropdown.Item>
          <NavDropdown.Item href="find-applied-credit">Find Applied Credit</NavDropdown.Item>          
        </NavDropdown>
      </Nav>
    </Navbar.Collapse>
  </Container>
</Navbar>
            </div>
        );
    }
}

export default NavbarComponent;