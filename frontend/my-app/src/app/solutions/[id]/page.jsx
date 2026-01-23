export default async function SolutionDetail({ params }) {
    const { id } = await params;

    return (
        <div className="flex items-center justify-center min-h-screen">
            <h1 className="text-center">Details of Solution ${id}</h1>
        </div>
    );
}