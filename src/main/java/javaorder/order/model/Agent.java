package javaorder.order.model;

import javax.persistence.*;

@Entity
@Table(name = "agents")
public class agents
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long agentcode;

    private String agentname;
    private String workingarea;
    private double commission;
    private String phone;
    private String country;

    

}