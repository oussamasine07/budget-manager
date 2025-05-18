export interface Transaction {
  id: number | null | undefined,
  date: string | null | undefined,
  type: string | null | undefined,
  description: string | null | undefined,
  amount: number | null | undefined,
  budget: {
    id: number | null | undefined,
    amount: number | null | undefined,
    type: string | null | undefined,
    date: string | null | undefined
  } | null | undefined,
  category: {
    id: number | null | undefined,
    name: string | null | undefined,
    limite: number | null | undefined
  } | null | undefined
}
