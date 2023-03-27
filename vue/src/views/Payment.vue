<template>
    <a-row type="flex" :gutter="24">

        <!-- Billing Info Column -->
        <a-col :span="24" :md="16">
            <a-row type="flex" :gutter="24">
                <a-col :span="24" :xl="12" class="mb-24">
                    <CardCredit></CardCredit>
                </a-col>
                <a-col :span="24" :xl="12" class="mb-24">
                    <CardCredit></CardCredit>

                </a-col>
                <a-col :span="24" class="mb-24">
                    <CardPaymentMethods></CardPaymentMethods>
                </a-col>
            </a-row>
        </a-col>

        <a-col :span="24" :md="8" class="mb-24">

            <CardInvoices
                :data="invoiceData"
            ></CardInvoices>
        </a-col>

    </a-row>
</template>

<script>
import CardCredit from "@/components/Cards/CardCredit";
import WidgetSalary from "@/components/Widgets/WidgetSalary";
import CardPaymentMethods from "@/components/Cards/CardPaymentMethods";
import CardInvoices from "@/components/Cards/CardInvoices";
const invoiceData = [
    {
        title: "March, 01, 2021",
        code: "#1546336",
        amount: "12.5",
    },
    {
        title: "February, 12, 2021",
        code: "#6345321",
        amount: "12.5",
    },
    {
        title: "April, 05, 2020",
        code: "#2435141",
        amount: "12.5",
    },
    {
        title: "June, 25, 2019",
        code: "#6473567",
        amount: "12.5",
    },
    {
        title: "March, 03, 2019",
        code: "#2546524",
        amount: "12.5",
    },
] ;
export default {
    name: "Payment",
    data() {
        return {
            invoiceData,
        };
    },
    components: {
        CardCredit,
        WidgetSalary,
        CardPaymentMethods,
        CardInvoices
    },
}
</script>

<style scoped>

</style>
