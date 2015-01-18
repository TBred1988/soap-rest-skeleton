<h3>Logged in </h3>
<label>${user.firstName}&nbsp;${user.lastName}</label>
<ul class="options">
    <li class="option-item"><a id="show-items">Items</a></li>
</ul>
<div id="items-popup">
    <a class="close">Close</a>
    <a id="add-item" class="standard-button">Add</a>
    <div id="item-new">
        <a class="close">Close</a>
        <form name="new-item-form">
            Name: <input type="text" name="name">
            Price(HU): <input type="number" name="price_HU">
            Short name: <input type="text" name="shortName">
            <a id="create-new-item" class="standard-button">Create</a>
        </form>
    </div>
    <div id="items-container" />
</div>