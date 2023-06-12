import networkx as nx
import matplotlib.pyplot as plt
import matplotlib.animation as animation
from Utils import get_and_remove_first_items


def animate_route(stores, k_max_units):
    # Create the graph
    G = nx.Graph()
    truck_payload = []

    # Add the nodes to the graph
    for i in range(len(stores['route'])):
        store = stores['route'][i]
        index = store.index
        x = store.x
        y = store.y
        delivery = store.delivery
        G.add_node(index, pos=(x, y), delivery=delivery)

        # Create edges between the current store and the next store
        if i < len(stores['route']) - 1:
            next_store = stores['route'][i + 1]
            G.add_edge(index, next_store.index)

    # Define the layout of the graph using the positions of the nodes
    pos = nx.get_node_attributes(G, "pos")

    # Create a function to update the plot for each frame of the animation
    def update(frame):
        nonlocal truck_payload  # Declare truck_payload as nonlocal

        plt.clf()  # Clear the current plot

        # Draw the nodes of the graph with their positions
        nx.draw_networkx_nodes(G, pos, node_color="lightblue", node_size=500)
        # Draw the edges of the graph
        nx.draw_networkx_edges(G, pos)
        # Draw the node labels with the delivery numbers and index
        labels = {index: index for index in G.nodes()}  # Use index as label
        nx.draw_networkx_labels(G, pos, labels=labels)

        # Add the delivery number of the truck as the title
        fuel_used = stores['fuel_used']

        store = stores['route'][frame]

        # Add items to the truck payload
        truck_payload += get_and_remove_first_items(
            store.delivery, k_max_units - len(truck_payload))

        # Remove the items from the visited store
        if store.index in truck_payload:
            truck_payload.remove(store.index)

        plt.title(
            f"Iteração: {frame}\nCombustível usado: {fuel_used}\nNúmero de itens no caminhão: {truck_payload}")

        # Animate the truck moving to the next store
        if frame < len(stores['route']) - 1:
            current_store = store
            next_store = stores['route'][frame + 1]
            nx.draw_networkx_edges(G, pos, edgelist=[(
                current_store.index, next_store.index)], edge_color='red', width=2)

    # Set the size of the figure
    plt.figure(figsize=(10, 8))

    # Create the animation using the update function and the number of deliveries as frames
    ani = animation.FuncAnimation(plt.gcf(), update, frames=len(
        stores['route']), interval=2000, repeat=False)

    # Display the animation
    plt.show()

    # Close animation
    plt.close()
