**Demo projects**

**milestone 1**

`counsul-client` demo to show some basic usage for consul and spring cloud config
in ideal consul should be used with haproxy to load balance. 


`service-one` shows usage of feign, client load balancing and integration with consul
`consul-client` `consul-client-two` two services that have the same service name in consul
folder `consul-client` contains consul and git2consul docker image


Links:
- https://github.com/Cimpress-MCP/git2consul

**milestone 2**
HAProxy with consul-template is for external clients

**milestone 3**

Docker swarm is good for both.
the next demo is to provide docker swarm with spring cloud config
and show cluster of docker swarm between different clouds.


**milestone 4**

Float ip for HAProxy

Difference between spring cloud config. 
Actually it could replace spring cloud config and actually this is more powerful for on-precise.
In clouds we don't need it as everything is under cloud load balancer (like aws load balancer)
