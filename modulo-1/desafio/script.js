let employees, roles;
let rolesFilter = [];

init();

async function init() {
    document.querySelector("main div.button-wrapper div.button").addEventListener("click", (e) => {
        const button = e.currentTarget;
        const pageContainer = document.querySelector("div.page-container");
        if (button.classList.contains("hide")) {
            button.classList.replace("hide", "show");
            for (let element of pageContainer.children) {
                element.classList.add("hidden-menu");
            }
        } else {
            button.classList.replace("show", "hide");
            for (let element of pageContainer.children) {
                element.classList.remove("hidden-menu");
            }
        }
    });

    document.querySelector("aside label select").addEventListener("change", () => {
        switch (document.querySelector("aside label select option:checked").value) {
            case "na":
                renderTable(employees.sort(sortNameAsc));
                break;
            case "nd":
                renderTable(employees.sort(sortNameDesc));
                break;
            case "sa":
                renderTable(employees.sort(sortSalAsc));
                break;
            default:
                renderTable(employees.sort(sortSalDesc));
        }
    });

    await Promise.all([
        fetch("http://localhost:3000/employees").then(r => r.json()),
        fetch("http://localhost:3000/roles").then(r => r.json())
    ]).then(r => {
        employees = r[0];
        roles = r[1];
    });
    renderRoles(roles);
    renderTable(employees.sort(sortNameAsc));
    
    document.querySelectorAll("aside fieldset label input").forEach((input) => {
        input.addEventListener("change", filterRole);
    });
}

function renderRoles(roles) {
    const fieldset = document.querySelector("aside fieldset");

    for (const r of roles) {
        const label = document.createElement("label");
        const input = document.createElement("input");
        const span = document.createElement("span");

        input.type = "checkbox";
        input.value = r.id;
        input.name = "filter";

        span.textContent =` ${r.name}`;

        label.appendChild(input);
        label.appendChild(span);

        fieldset.appendChild(label);
    }
}

function renderTable(data) {
    const tbody = document.createElement("tbody");
    const h1span = document.querySelector("main h1 span");
    let counter = 0;

    for (e of data) {
        if (rolesFilter.length > 0 && !rolesFilter.includes(e.role_id)) {
            continue;
        }
        const tr = document.createElement("tr");

        const id = document.createElement("td");
        id.textContent = `${e.id}`;

        const name = document.createElement("td");
        name.textContent = `${e.name}`;

        const roleId = document.createElement("td");
        roleId.textContent = `${roles[e.role_id - 1].name}`;

        const salary = document.createElement("td");
        salary.textContent = `${e.salary}`;

        tr.appendChild(id);
        tr.appendChild(name);
        tr.appendChild(roleId);
        tr.appendChild(salary);
        tbody.appendChild(tr);

        counter++;
    }
    document.querySelector("main table tbody").replaceWith(tbody);
    h1span.textContent = `${counter}`;
}

function sortNameAsc(a, b) {
    return a.name > b.name ? 1 : (a.name < b.name ? -1 : 0);
}

function sortNameDesc(a, b) {
    return a.name < b.name ? 1 : (a.name > b.name ? -1 : 0);
}

function sortSalAsc(a, b) {
    return a.salary > b.salary ? 1 : (a.salary < b.salary ? -1 : 0);
}

function sortSalDesc(a, b) {
    return a.salary < b.salary ? 1 : (a.salary > b.salary ? -1 : 0);
}

function filterRole(event) {
    const checkbox = event.target;
    const value = +checkbox.value;
    if (checkbox.checked) {
        rolesFilter.push(value)
    } else {
        rolesFilter.splice(rolesFilter.indexOf(value), 1);
    }

    renderTable(employees);
}